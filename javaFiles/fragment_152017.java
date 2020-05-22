#!/bin/bash
# Having some trouble running Eclipse on the latest Open Client for Linux?
# This front-end collection of kluges may help.

# Workaround for some other display bugs, not currently needed...?
# export GDK_NATIVE_WINDOWS=true

# Environment switch: Workaround for tooltip bug
export GRE_HOME=/DOESNOTEXIST

# Java switch: Workaround for Cairo breakage. 
# This could go into eclipse.ini
NOCAIRO=-Dorg.eclipse.swt.internal.gtk.cairoGraphics=false

# Java switch: Workaround for xulrunner breakage
#   There seems to be an open question about which versions work, if any.
#   Some suggest pointing to a specific 1.9 build, some suggest disabling.
#   I'm trying without that change for now.
# Something like this could go into eclipse.ini
#NOXUL=-Dorg.eclipse.swt.browser.XULRunnerPath=/dev/nul
NOXUL=

# Apply NOCAIRO/NOXUL switches from above
# Plus Joe's additional opts...
#   Show class and workspace name in Eclipse window header
eclipse -showlocation -vmargs ${NOCAIRO} ${NOXUL}