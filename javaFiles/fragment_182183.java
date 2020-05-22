searchpath = 'ParforProgMonv2/java'; % Directory to search for

if strcmp(MonitorProcess, 'Yes')
    switch computer
        case {'PCWIN', 'PCWIN64'}
            % 32 or 64 bit Windows
            % Use the system command to return all directories found on the machine
            % that match your search directory. Use a regex to clean up the list
            [~, cmdout] = system(['dir /s/b/AD | find "' searchstr '"');
            allpaths = regexp(cmdout, '(.:\\[\w\-\\. ]+\w+(?=\s))', 'match'); % Split directory names, 1st cell should be the top level
            pctRunOnAll javaaddpath (allpaths{1})
        case 'GLNXA64'
            % Linux
            pctRunOnAll javaaddpath ('/home/dkumar/ParforProgMonv2/java')
        otherwise
            % Insert error handling here
    end
end