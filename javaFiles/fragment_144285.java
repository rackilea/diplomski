Cell cell = new Cell(this, txt, 50, 50);
 cell.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("value is " + value);

                }
            });