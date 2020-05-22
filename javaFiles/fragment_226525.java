class BootStrap {
  def init = { servletContext ->
    println "$servletContext.contextPath"
  }
  def destroy = {
  }
}