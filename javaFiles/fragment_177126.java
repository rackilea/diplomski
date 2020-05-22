#private static String encodeGwpwes002(String code, int codeSize) {
function encodeGwpwes002([string]$code, [int]$codeSize = 0){
    #byte[] protectCode;
    [byte]$protectCode | Out-Null
    #try {
    try{
        #protectCode = code.getBytes("UTF-8");
        $protectCode = [System.Text.Encoding]::UTF8.GetBytes($code)
    #}catch (Throwable e) {
    }catch{
        #return null;
        return $null
    #}
    }
    #int encodeSize = codeSize;
    [int]$encodeSize = $codeSize
    #if (protectCode.length >= codeSize) {
    if(($protectCode.length) -ge $codeSize){
        #encodeSize = protectCode.length + 9;
        $encodeSize = ($protectCode.length) + 9
    #}
    }
    #byte[] simple = new byte[encodeSize];
    [byte[]]$simple = New-Object byte[] $encodeSize
    #int diffuseCnt = 0;
    [int]$diffuseCnt = 0
    #int simpleCnt = 0;
    [int]$simpleCnt = 0
    #if (protectCode.length < encodeSize - 1) {
    if(($protectCode.length) -lt ($encodeSize - 1)){
        #for (diffuseCnt = 0; diffuseCnt < encodeSize - 1 - protectCode.length; ++diffuseCnt) {
        for($diffuseCnt = 0; $diffuseCnt -lt ($encodeSize - 1 - ($protectCode.length)); $diffuseCnt++){
            #simple[diffuseCnt] = (byte)(Math.random() * 25.0 + 97.0);
            $simple[$diffuseCnt] = [byte] (Get-Random -Maximum 0.9 -Minimum 0.1) * 25.0 + 97.0
        #}
        }
    #}
    }
    #simple[diffuseCnt++] = 122;
    $simple[$diffuseCnt++] = 122
    #for (simpleCnt = diffuseCnt; simpleCnt < protectCode.length + diffuseCnt; ++simpleCnt) {
    for($simpleCnt = $diffuseCnt; $simpleCnt -lt ($protectCode.length) + $diffuseCnt; $simpleCnt++){
        #simple[simpleCnt] = protectCode[simpleCnt - diffuseCnt];
        $simple[$simpleCnt] = $protectCode[$simpleCnt - $diffuseCnt];
    #}
    }
    #byte[] encrypt = new byte[simpleCnt];
    [byte[]] $encrypt = New-Object byte[] $simpleCnt
    #for (int i = 0; i < simpleCnt; ++i) {
    for([int]$i=0; $i -lt $simpleCnt; $i++)  {  
        #byte work = 0;
        [byte]$work = 0
        #work = (byte)((simple[i] & 192) >>> 6 | (simple[i] & 63) << 2);
        $work = [byte](($simple[$i] -band 192) -shr 6 -bor ($simple[$i] -band 63) -shl 2)
        #encrypt[i] = (byte)((work & 240) >>> 4 | (work & 15) << 4);
        $encrypt[$i] = [byte](($work -band 240) -shr 4 -bor ($work -band 15) -shl 4)
    #}
    }
    #return new String(Base64.encodeBase64((byte[])encrypt));
    return [string]([System.Convert]::ToBase64String([byte[]]$encrypt))
#}
}

encodeGwpwes002TEST -code "Test"