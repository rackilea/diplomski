#!/bin/bash

cd `$CYGWIN_HOME/bin/pwd.exe`/gettext

set CYGWIN_HOME=%CYGWIN_HOME%
set GETTEXT_HOME=%GETTEXT_HOME%

$CYGWIN_HOME/bin/rm.exe -fv files.txt
$CYGWIN_HOME/bin/find.exe ../src/main/java -name *.java > files.txt

$CYGWIN_HOME/bin/mkdir.exe -pv po

$GETTEXT_HOME/xgettext.exe -ktrc -ktr -kmrktr -ktrn:1,2 --from-code=UTF-8 -o po/keys.pot -f files.txt

$CYGWIN_HOME/bin/sed.exe -i 's/CHARSET/UTF-8/g' po/keys.pot

if [ ! -f po/pl.po ]; then
     $CYGWIN_HOME/bin/cp.exe -v template.po po/pl.po
fi

$GETTEXT_HOME/msgmerge.exe -U po/pl.po po/keys.pot

export JAVAC=`$CYGWIN_HOME/bin/pwd.exe`/javac.sh

$CYGWIN_HOME/bin/rm.exe -rfv tmp
$CYGWIN_HOME/bin/mkdir.exe -pv tmp
export TMPDIR=`$CYGWIN_HOME/bin/pwd.exe`/tmp/

$GETTEXT_HOME/msgfmt.exe --verbose --java2 -d tmp -r com.haso.i18n.Messages po/keys.pot
$GETTEXT_HOME/msgfmt.exe --verbose --java2 -d tmp -r com.haso.i18n.Messages -l pl po/pl.po

$CYGWIN_HOME/bin/rm.exe -rfv ../src/main/java/com/haso/i18n
$CYGWIN_HOME/bin/mkdir.exe -pv ../src/main/java/com/haso/i18n

$CYGWIN_HOME/bin/find.exe tmp -name "Messages*.java" | $CYGWIN_HOME/bin/xargs.exe -n 1 $CYGWIN_HOME/bin/cp.exe -vt ../src/main/java/com/haso/i18n/