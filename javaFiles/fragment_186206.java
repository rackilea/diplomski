layoutMerchant.setOnClickListener{
                //setContentView(R.layout.activity_merchant_service)
                val intent = Intent(this@MerchantActivity, MerchantServiceActivity::class.java)
                startActivity(intent)
            }

            toolbarSelectMerchant.setOnClickListener{
               //setContentView(R.layout.activity_home)
                onBackPressed()
            }