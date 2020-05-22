@Entity(tableName = "chat_message_table", indices = [Index(value = ["messageId"], unique = true)])
data class Message(@ColumnInfo(name = "messageId") val messageId: String) {
 @PrimaryKey(autoGenerate = true)
 var _Id: Int = 0
 ...
 }