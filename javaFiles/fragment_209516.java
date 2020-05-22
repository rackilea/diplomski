while (st.isEmpty()) {
  topStack = (char) st.peek();
  if (topStack != '(') {
    st.pop();
    postfixString = postfixString + topStack;
  }
}