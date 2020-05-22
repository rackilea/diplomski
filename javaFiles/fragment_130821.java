@Override
        public void run() {
            // TODO Auto-generated method stub
            startActivity(Vert.this.m1);
            m1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            finish();
    }