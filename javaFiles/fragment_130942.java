if [ -z "$1" ]; then
   echo "Please specify which language_country suffix(es) you want"
   exit 1
fi

for lang in $*
do
  echo "Creating .properties template file for $lang"

  msgcat --properties-output msgs/${lang}.po -o src/com/i18n/Messages_${lang}.properties
 msgs/messages.pot
done