class Builder {
  final boolean cloned;

  Builder(MetricHolder packet) {
    this.cloned = true;
    // ...
  }

  Builder(Record record) {
    this.cloned = false;
    // ...
  }
}