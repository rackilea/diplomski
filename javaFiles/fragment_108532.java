@Override
  protected void process(List<Double> chunks) {
     if (isCancelled()) {
        return;
     } else {
        String numberTxt = String.format("%5.3f",
              chunks.get(chunks.size() - 1));
        jlStatus.setText(numberTxt);
     }

     // jlStatus.setText("" + chunks.get(chunks.size() - 1));
     // System.out.println(chunks.get(chunks.size() - 1));
  }