public override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                                     savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.fragment_blank, container, false)

        //update you UI from local STORAGE on create
        textView.text = sharedPreference.getInt("result_data", 0).toString()//make request local for date


        //calling your calculation
        button.setOnClickListener {

            calculateData(dataInput, object : Callback {
                override fun onCalculated() {

                    //update you UI from local STORAGE layer in MAIN THREAD
                    Handler(Looper.getMainLooper()).post {
                        textView.text = sharedPreference.getInt( 
                                  "result_data",0
                          ).toString()
                    }
                }

            })
        }
    }

//you calculate and request to data layer

    private fun calculateData(inPutData:Int, callback:Callback){

           //use background for calculate It will be available. 
           Thread{

                //calculate
                val result = inPutData+ ARG_PARAM 

                //save result in LOCAL STORAGE
                sharedPreference.edit().putInt( " result", result).apply()

               //update UI 
               callback.onCalculated()

            }.start()

        }

    interface Callback{
        fun onCalculated()

    }