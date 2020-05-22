@Entity
data class ChatMsg(var msg: String, var to: Int) {
    constructor() : this("", UNKNOWN);

    companion object TO {
        val MASTER = 0
        val ROBOT = 1
        private val UNKNOWN = -1; // just use for initializing
    }

    @field: PrimaryKey(autoGenerate = true)
    var id: Int = 0
}