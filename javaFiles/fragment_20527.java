invoke-virtual {v0}, Ljava/util/ArrayList;->toString()Ljava/lang/String; # where v0 is your ArrayList

move-result-object v1

const-string/jumbo v2, "SomeTag"

invoke-static {v2, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I