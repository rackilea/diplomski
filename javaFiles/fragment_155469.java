public class MainActivity extends AppCompatActivity implements FragAHandler, FragBHandler {
        LinearLayout layRoot;
        FragmentManager manager = getSupportFragmentManager();


        Frag_a fragmentObjA;
        Frag_b fragmentObjB;
        public static final String FRAG_A_TAG = "FRAG_A";
        public static final String FRAG_B_TAG = "FRAG_B";


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            initialise();

            if (manager.findFragmentByTag(FRAG_A_TAG) == null && manager.findFragmentByTag(FRAG_B_TAG) == null) {
                //both are imp because of testcase not giving exact answer:
                // >>>open app: shows frag1>'press open frag2'>>>frg2 opens >'close frag 1' >>> rotate.
                //Expected output >> "fragment 2(already present object in backstack and on screen) to remain on screen
                //output recieved : both frag 1 and frg2 showing
                manager.beginTransaction().add(R.id.layout_root, fragmentObjA, FRAG_A_TAG)
                        .setTransitionStyle(FragmentTransaction.TRANSIT_ENTER_MASK)
                        .commit();
            } else {
                Toast.makeText(MainActivity.this, "frag1 Already present or fragment 2 present", Toast.LENGTH_SHORT).show();
            }

        }

        private void initialise() {
            layRoot = findViewById(R.id.layout_root);

            if(manager.findFragmentByTag(FRAG_A_TAG)!=null){
                fragmentObjA= (Frag_a) manager.findFragmentByTag(FRAG_A_TAG);
                Log.e(">>", "initialise: frgement A object recieved from the frag manager is used" );

            }
            else{
                Log.e(">>", "initialise:new frag a object created" );
                fragmentObjA=new Frag_a();

            }
            if(manager.findFragmentByTag(FRAG_B_TAG)!=null){
                fragmentObjB= (Frag_b) manager.findFragmentByTag(FRAG_B_TAG);

                Log.e(">>", "initialise: frgement B object recieved from the frag manager is used" );
            }
            else{
                Log.e(">>", "initialise:new frag object created" );
                fragmentObjB=new Frag_b();
            }
        }


        //-----------handler methods-------------------
        @Override
        public void addFrag1() {
            if (manager.findFragmentByTag(FRAG_A_TAG) == null) {
                manager.beginTransaction().add(R.id.layout_root, fragmentObjA, FRAG_A_TAG)
                        .setTransitionStyle(FragmentTransaction.TRANSIT_ENTER_MASK)
                        .commit();
            } else {
                Toast.makeText(MainActivity.this, "frag1 Already present", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void closeFrag1() {
            Frag_a fragA = (Frag_a) manager.findFragmentByTag(FRAG_A_TAG);
            if (fragA != null) {
                manager.beginTransaction().remove(fragA)
                        .setTransitionStyle(FragmentTransaction.TRANSIT_EXIT_MASK)
                        .commit();
            } else {
                Toast.makeText(MainActivity.this, "frag1 Already not there", Toast.LENGTH_SHORT).show();

            }

        }

        @Override
        public void addFrag2() {

            if (manager.findFragmentByTag(FRAG_B_TAG) == null) {
                manager.beginTransaction().add(R.id.layout_root, fragmentObjB, FRAG_B_TAG)
                        .setTransitionStyle(FragmentTransaction.TRANSIT_ENTER_MASK)
                        .commit();
            } else {
                Toast.makeText(MainActivity.this, "frag2 Already present", Toast.LENGTH_SHORT).show();
            }


        }

        @Override
        public void closeFrag2() {
            Frag_b frag_b = (Frag_b) manager.findFragmentByTag(FRAG_B_TAG);

            if (frag_b != null) {
                manager.beginTransaction().remove(frag_b)
                        .setTransitionStyle(FragmentTransaction.TRANSIT_EXIT_MASK)
                        .commit();
            } else {
                Toast.makeText(MainActivity.this, "frag2 Already not there", Toast.LENGTH_SHORT).show();

            }

        }

    }