Object.defineProperty(String.prototype, "getNumericValue", {
  value() {
    return parseInt(this, 36);
  },
  writable: true,
  configurable: true
});

console.log("A".getNumericValue()); // 10