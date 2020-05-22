public void removeAllElements() {

        int index1 = delegate.size()-1;
        delegate.removeAllElements();

        if (index1 >= 0) {
            fireIntervalRemoved(this, 0, index1);
        }

}