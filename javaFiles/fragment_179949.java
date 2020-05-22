public RealtekSurfaceView(Context context,String filePath,String videoType,int x,int y,int width,int height,boolean HDMI_AV){
super(context);
  this.mContext=context;
  this.videoType=videoType;
  this.width=width;
  this.height=height;
  this.HDMI_AV=HDMI_AV;
  this.videoPath=filePath;
  this.mSurfaceHolder = getHolder();
  this.mSurfaceHolder.addCallback(new SurfaceCallback());
  this.mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
  setBackgroundColor(Color.TRANSPARENT);

init(); <-- you have to add this, as you are forgetting to initialize the broadcast receiver