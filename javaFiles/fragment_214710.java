f = figure();
p = uix.TabPanel('Parent', f,'Padding', 5);
uicontrol('Style', 'frame', 'Parent', p, 'Background', 'r');
uicontrol('Style', 'frame', 'Parent', p, 'Background', [.8 .8 .8]);
uicontrol('Style', 'frame', 'Parent', p, 'Background', 'g');
p.TabTitles = {'Red', 'Gray', 'Green'};
p.Selection = 2;
p.TabEnables = {'on','on','off'};