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
          this.children= new TrieNode("1");
          this.c = c;
          this.isLeaf;
      }
      constructorNoParam() {
          this.children = new TrieNode("1");
          this.c;
          this.isLeaf;
      }
    }