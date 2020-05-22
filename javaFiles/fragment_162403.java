// important this code needs to be in the package com.firebase.client
Config config1 = new Config();
Config config2 = new Config();
Firebase ref1 = new Firebase("https://<your-firebase>.firebaseio.com", config1);
Firebase ref2 = new Firebase("https://<your-firebase>.firebaseio.com", config2);
// ref1 and ref2 will now have independent connections, listeners and authentication states