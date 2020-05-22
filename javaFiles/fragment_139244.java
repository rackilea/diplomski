String rs = "";
                GetResult foo = new GetResult();
                new Thread(foo).start();
                foo.join(); // will wait till foo finish

                rs = foo.getbodyHtml();


            edittext2.setText(rs);