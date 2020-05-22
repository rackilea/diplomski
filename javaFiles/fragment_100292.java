#!/bin/bash

>combined.csv
for xml in *.xml
do
  echo "Processing $xml";
  id=$({ xmllint --xpath "string(//customer/id)" $xml; echo ","; } | tr "\n" " ");
  firstname=$({ xmllint --xpath "string(//customer/firstName)" $xml; echo ","; } | tr "\n" " ");
  phonenumber=$(xmllint --xpath "string(//customer/phoneNumbers)" $xml);
  line="${id}${firstname}${phonenumber}\n"
  printf "$line" >> combined.csv
done