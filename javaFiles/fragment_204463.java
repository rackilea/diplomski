dsl.transaction { () ->
    dsl.connection { connection ->
        val manager = CopyManager(connection as BaseConnection)
        manager.copyInto(table, inputStream, fields)
    }
}