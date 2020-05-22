class MyClass<T : Message> {
    private val nodes: MutableList<TopicNode<T>>

    init {
        this.nodes = ArrayList()
    }

    private fun findNode(topic: String): TopicNode<T>? {
        for (node in nodes) {
            if (node.topic == topic) {
                return node // No need to cast
            }
        }
        return null
    }
}