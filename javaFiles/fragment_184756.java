implicit val implicitTaskWrites = new Writes[Task] {
def writes(taskobj: Task): JsValue = {
  Json.obj(
    "id" -> taskobj.id,
    "label" -> taskobj.label
  ) 
}