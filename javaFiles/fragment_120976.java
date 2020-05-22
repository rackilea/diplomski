#echo "Input Command : $1"
TOTAL_CHANGES_WITH_FILES="$($1 | grep '^+' | wc -l)"
TOTAL_CHANGED_FILES="$($1 | grep '^+++' | wc -l)"
RESULT=`expr ${TOTAL_CHANGES_WITH_FILES} - ${TOTAL_CHANGED_FILES}`
#echo "Total Changed Lines: ${RESULT}"
echo "${RESULT}"