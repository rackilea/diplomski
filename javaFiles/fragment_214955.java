Public Sub LaunchMinecraft(ByRef AccessToken As String, ByRef ClientToken As String)

    Dim Xmx As String = "4G"
    Dim Xms As String = "2G"
    Dim Title As String = "My Minecraft Instance"
    Dim Version As String = "1.7.10"
    Dim AssetIndex As String = "..." ' AssetIndex obtained from mojang server
    Dim Username As String = "..." ' Minecraft username obtained from mojang server
    Dim Libraries As String = "..." ' Paths to all libraries separated by ;

    Dim JavaProcess As Process = New Process()
    JavaProcess.StartInfo.UseShellExecute = False
    JavaProcess.StartInfo.CreateNoWindow = False
    JavaProcess.StartInfo.FileName = "..." ' Path to javaw.exe or java.exe
    JavaProcess.StartInfo.Arguments = "-XX:HeapDumpPath=MojangTricksIntelDriversForPerformance_javaw.exe_minecraft.exe.heapdump" +
                            " -Xmx" + Xmx +
                            " -Xms" + Xms +
                            " -Djava.library.path=.//bin/natives" +
                            " -Dminecraft.client.jar=.//bin/modpack.jar" +
                            " -Dminecraft.applet.TargetDirectory=.//" +
                            " -cp .//bin/modpack.jar;" + Libraries + ";.//bin/minecraft.jar" +
                            " -XX:+UnlockExperimentalVMOptions" +
                            " -XX:+UseG1GC -XX:G1NewSizePercent=20" +
                            " -XX:G1ReservePercent=20" +
                            " -XX:MaxGCPauseMillis=50" +
                            " -XX:G1HeapRegionSize=16M" +
                            " net.minecraft.launchwrapper.Launch" +
                            " --gameDir .//" +
                            " --username " + Username +
                            " --assetsDir ..//..//..//cache/assets" +
                            " --assetIndex " + AssetIndex +
                            " --version " + Version +
                            " --uuid " + ClientToken +
                            " --accessToken " + AccessToken +
                            " --userProperties {}" +
                            " --userType mojang" +
                            " --tweakClass cpw.mods.fml.common.launcher.FMLTweaker" +
                            " --title " + Title
    JavaProcess.Start()

End Sub