#!/bin/bash

# Example list of regions (full list can be obtained from https://www.ip2location.com/free/iso3166-2 )
REGIONS="VE-O GB-BKM GB-CAM GB-CMA"

for REGION in $REGIONS; do 
LATLON=$(curl -s "maps.googleapis.com/maps/api/geocode/json?sensor=false&address=$REGION" | jq -r '.results[0].geometry.location.lat,@text ",",.results[0].geometry.location.lng')
echo $REGION , $LATLON |  tr -d ' '
done