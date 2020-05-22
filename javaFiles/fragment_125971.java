public boolean onTouch(View v, MotionEvent event) {

            Ponto2D patual = new Ponto2D((int)event.getX(), (int)event.getY());
            Reta r1 = new Reta (inicio, fim);

            //DrawView.ar[contador] =rl[]; //offending line
            //it should be
            //drawView.ar = something; but thats also wrong because you cannot refer to a non-final variable drawView in a inner-class blahblah so here's what you do
            ((DrawView)v).ar[contador] = rl; //or whatever you want it to be