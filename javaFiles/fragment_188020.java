fun getFile(user: User, messageId: Long, fileId: Short, response: HttpServerResponse) {
        val mediaContent = mediaContentRepository.getFile(messageId, fileId)
        when {
            mediaContent == null ->
                response.apply { statusCode = 404 }.end()
            conversationUserRepository.authorize(user.id!!, mediaContent.message!!.conversation!!.id, mediaContent.message!!.created) ->
                response.putHeader("Content-Disposition", "attachment; filename=\"${mediaContent.name}\"") //TODO: prevent injections
                        .putHeader("Content-Type", mediaContent.contentType)
                        .putHeader("Content-Length", mediaContent.file.length().toString())
                        .apply {
                            val stream = mediaContent.file.binaryStream
                            val byteArray = ByteArray(BUFFER_SIZE)
                            for (i in (0L..(mediaContent.file.length() / BUFFER_SIZE))) {
                                val bytesRead = stream.read(byteArray)
                                write(Buffer(io.vertx.core.buffer.Buffer.buffer(byteArray)
                                        .let {
                                            if (bytesRead == BUFFER_SIZE) it
                                            else it.slice(0, bytesRead)
                                        }))
                            }
                        }
                        .end()
            else ->
                response.apply { statusCode = 403 }.end()
        }
    }