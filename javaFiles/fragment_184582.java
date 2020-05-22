while (!this.empty()) {
        if (this.peek().getKey() > n.getKey()) {
            tempStack.push(this.pop());
        }
        else {
            break;
        }
    }