Thread.start(new Runnable() {
  public void main() {
    Process p = startProcess()
    p.waitFor()
    fireEvent()
  }
})