// before
      //  data[0][0] = Double.toString(price);
      //  data[0][1] = nameOfProduct;
      //  data[0][2] = Integer.toString(NumberOfItems);
      //  data[0][3] = Double.toString(subtotal);
      // after
      tableModel.addRow(new Object[]{Double.toString(price),
                             nameOfProduct,
                             Integer.toString(NumberOfItems),
                             Double.toString(subtotal)});