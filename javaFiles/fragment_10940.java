class Originator {
    /* irrelevant declarations skipped */

    abstract inner class Memento

    private inner class MementoImpl(val state: State) : Memento()

    fun saveState(): Memento {
        return MementoImpl(State(id, title, description))
    }

    fun restore(memento: Memento) {
        memento as MementoImpl
        id = memento.state.id
        title = memento.state.title
        description = memento.state.description
    }
}