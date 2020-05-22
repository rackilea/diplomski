const regex = /(.+?)([0-9]+)\s\[m.+/gm;
const str = `2019 May 22 03:32:17.952296 france1v4 sh[4937]: 190522-03:32:17.951792 [mod=REC, lvl=INFO] [tid=26130] Recording A8602096210405800406L200218680503121519 size is 4145956224 bytes
2019 May 22 03:32:17.952387 france1v4 sh[4937]: 190522-03:32:17.951895 [mod=REC, lvl=INFO] [tid=26130] RecordingInfo = fffocap://0x401e
2019 May 22 03:32:17.952466 france1v4 sh[4937]: 190522-03:32:17.951934 [mod=REC, lvl=INFO] [tid=26130] recording_dvr_from_recording_info:physicalSegmentCount=10   
`;
const subst = `$2`;

// The substituted value will be contained in the result variable
const result = str.replace(regex, subst);

console.log('Substitution result: ', result);