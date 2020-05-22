echo "Export-Package: foo.bar.bla,
    foo.bar.blo,
    foo.bor.ble,
    foo.bor.bli
    Bundle-RequiredExecutionEnvironment: JavaSE-1.8
" | cat MANIFEST.MF | awk '/Export-Package:(.*)/ {print $2; flag=1; next} flag && /:/ {flag=0;next} flag {print}' | sed 's/,//g'