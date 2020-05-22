public MySurface(Context context) {
                super(context);
                // TODO Auto-generated constructor stub

                    this.setBackgroundColor(Color.TRANSPARENT);                 
                    this.setZOrderOnTop(true); //necessary                
                    getHolder().setFormat(PixelFormat.TRANSPARENT); 
                    getHolder().addCallback(this); 
                    ourHolder = getHolder();

            }