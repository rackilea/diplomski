for (int i=0;i < size;i++) {
        if (this.getElementAt(i).equals(name)) {
            this.remove(i);
            success = true;
        }
    }