import java.util.*;
 import java.text.*; 
 import java.io.*;
 int n = Integer.parseInt(vars.get("COUNT")); 
 for (int i=1;i<=n;i++)
 {
      props.setProperty("UPSTREAM_"+i, vars.get("UPSTREAM_"+i));
 }