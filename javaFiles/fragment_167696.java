// this WILL NOT COMPILE !
Enjoyable enjoyable=new Enjoyable.Exercisable() {
            public void enjoy() {
                System.out.println(":D");
            }

            public void exercise() {
                System.out.println("Doing exercise !!!");

            }
        }.enjoy();