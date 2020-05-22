First you need to call 
super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);

Then do your intilization of buttons

final Button RsaButton = (Button) findViewById(R.id.RSA);

     final Button RsaInfoButton = (Button) this.findViewById(R.id.RSAInfo);
     final Button AesButton = (Button) this.findViewById(R.id.AES);

     final Button CaesarNormalButton =                                                                          (Button)this.findViewById(R.id.CaesarNormal);
     final Button CaesarNormalInfoButton = (Button) this.findViewById(R.id.CaesarNormalInfo);
     final Button CaesarAutomaticButton = (Button) this.findViewById(R.id.CaesarAutomatic);
     final Button CaesarAutomaticInfoButton = (Button) this.findViewById(R.id.CaesarAutomaticInfo);