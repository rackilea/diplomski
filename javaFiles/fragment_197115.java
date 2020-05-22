[mpenning@Finger ~]$ sudo tshark -n -V -i eth0 igmp
Running as user "root" and group "root". This could be dangerous.
Capturing on eth0
Frame 1 (54 bytes on wire, 54 bytes captured)
    Arrival Time: Dec  6, 2011 09:08:45.156782000
    ... >snip< ...
Internet Protocol, Src: 192.168.12.238 (192.168.12.238), Dst: 224.0.0.22 (224.0.0.22)
    Version: 4
    Header length: 24 bytes
    Differentiated Services Field: 0xc0 (DSCP 0x30: Class Selector 6; ECN: 0x00)
        1100 00.. = Differentiated Services Codepoint: Class Selector 6 (0x30)
        .... ..0. = ECN-Capable Transport (ECT): 0
        .... ...0 = ECN-CE: 0
    Total Length: 40
    Identification: 0x0000 (0)
    Flags: 0x02 (Don't Fragment)
        0.. = Reserved bit: Not Set
        .1. = Don't fragment: Set
        ..0 = More fragments: Not Set
    Fragment offset: 0
    Time to live: 1
    Protocol: IGMP (0x02)
    Header checksum: 0x3663 [correct]
        [Good: True]
        [Bad : False]
    Source: 192.168.12.238 (192.168.12.238)
    Destination: 224.0.0.22 (224.0.0.22)
    Options: (4 bytes)
        Router Alert: Every router examines packet
Internet Group Management Protocol
    [IGMP Version: 3]
    Type: Membership Report (0x22)
    Header checksum: 0xe9fd [correct]
    Num Group Records: 1
    Group Record : 239.255.0.1  Change To Exclude Mode
        Record Type: Change To Exclude Mode (4)
        Aux Data Len: 0
        Num Src: 0
        Multicast Address: 239.255.0.1 (239.255.0.1)

^C1 packet captured