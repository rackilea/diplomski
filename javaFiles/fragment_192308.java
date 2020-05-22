try{
        request.outputStream.write(httpBody)
    }catch (e: Throwable){
        request.outputStream.close()
        failure?.invoke(null, hashMapOf("error" to "Issue writing to URL"))
        return Unit
    }