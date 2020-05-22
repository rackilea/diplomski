class Payload {
   @BeanProperty var id: Long = _
   override def toString = s"Payload($id)"
} 
class JsonBeanExample() {
  def process(payload: Payload): Unit = {
     println(s"recieved ${payload}")
  }
}