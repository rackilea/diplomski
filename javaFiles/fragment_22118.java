class MyClass<T : Message> {
    private val nodes: MutableList<TopicNode<T>> = ArrayList()

    private fun findNode(topic: String)
        = nodes.find{ it.topic == topic }
}