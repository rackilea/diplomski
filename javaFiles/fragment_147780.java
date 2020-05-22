line.replaceAll("(00:?)+(.0)?\s*([AP]M)", "");

(              // start time group
00             // strange timestamp symbol
:?             // allow ':'
)+             // strange group can be repeated more than one time
(.0)?          // if ms was specified
\s*            // allow spaces before AM,PM
(              // AM, PM group
[AP]           // A or P letter
M              // M
)?             // AP, PM group can not exists