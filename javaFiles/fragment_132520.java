document.NewPage();
// get the total number of pages that needs to be reordered
int total = writer.ReorderPages(null);
// change the order
int[] order = new int[total];
for (int i = 0; i < total; i++) {
  order[i] = i + toc;
  if (order[i] > total) {
    order[i] -= total;
  }
}
// apply the new order
writer.ReorderPages(order);