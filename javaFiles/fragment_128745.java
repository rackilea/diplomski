[directories](!)
astetcdir => /tmp/asterisk-testsuite/apps/confbridge/ast1/etc/asterisk
astmoddir => /tmp/asterisk-testsuite/apps/confbridge/ast1/usr/lib/asterisk/modules
astvarlibdir => /tmp/asterisk-testsuite/apps/confbridge/ast1/var/lib/asterisk
astdbdir => /tmp/asterisk-testsuite/apps/confbridge/ast1/var/lib/asterisk
astkeydir => /tmp/asterisk-testsuite/apps/confbridge/ast1/var/lib/asterisk
astdatadir => /tmp/asterisk-testsuite/apps/confbridge/ast1/var/lib/asterisk
astagidir => /tmp/asterisk-testsuite/apps/confbridge/ast1/var/lib/asterisk/agi-bin
astspooldir => /tmp/asterisk-testsuite/apps/confbridge/ast1/var/spool/asterisk
astrundir => /tmp/asterisk-testsuite/apps/confbridge/ast1/var/run/asterisk
astlogdir => /tmp/asterisk-testsuite/apps/confbridge/ast1/var/log/asterisk

[options]
verbose = 5
debug = 5
defaultlanguage = en           ; Default language
documentation_language = en_US  ; Set the language you want documentation
                ; displayed in. Value is in the same format as
                ; locale names.   
[compat]
pbx_realtime=1.6
res_agi=1.6
app_set=1.6