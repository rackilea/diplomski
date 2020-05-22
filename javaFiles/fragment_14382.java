class TrieNode {
  constructor(time) {
      if(time === "1") return;
      switch(arguments.length) {
        case 0 : this.constructorNoParam();
        break;
        case 1 : this.constructorOneParam(arguments[0]);
        break;
      }
  }
  constructorOneParam(c) {
      this.children= TrieNode.children;
      this.c = c;
      this.isLeaf;
  }
  constructorNoParam() {
      this.children = TrieNode.children;
      this.c;
      this.isLeaf;
  }
}

TrieNode.children = new TrieNode("1");

// Now the code wont fall into a recursive loop
var x = new TrieNode();
var y = new TrieNode("foo", "bar");