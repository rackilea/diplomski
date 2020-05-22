# HELP myservice_seconds  
# TYPE myservice_seconds summary
myservice_seconds_count{application="micrometered",method="manual",} 4.0
myservice_seconds_sum{application="micrometered",method="manual",} 0.200378014
myservice_seconds_max{application="micrometered",method="manual",} 0.050115291
myservice_seconds_count{application="micrometered",method="supplier",} 4.0
myservice_seconds_sum{application="micrometered",method="supplier",} 0.200393455
myservice_seconds_max{application="micrometered",method="supplier",} 0.05011635
myservice_seconds_count{application="micrometered",method="sample",} 4.0
myservice_seconds_sum{application="micrometered",method="sample",} 0.200527005
myservice_seconds_max{application="micrometered",method="sample",} 0.050250191
# HELP myservice_aspect_seconds  
# TYPE myservice_aspect_seconds summary
myservice_aspect_seconds_count{application="micrometered",class="io.github.mweirauch.micrometered.eval.TimingStuff$MyService",method="helloAspect",} 4.0
myservice_aspect_seconds_sum{application="micrometered",class="io.github.mweirauch.micrometered.eval.TimingStuff$MyService",method="helloAspect",} 0.201824272
myservice_aspect_seconds_max{application="micrometered",class="io.github.mweirauch.micrometered.eval.TimingStuff$MyService",method="helloAspect",} 0.051014296