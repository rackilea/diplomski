START pht=node:__types__(className="org.sg.domain.Photo"),
cmt=node:__types__(className="org.sg.domain.Comments") 
MATCH pht-[r:HAS]-x,pht-[t:taken_at]-x, cmt-[s]-y 
WHERE pht.photoId="MhQ2W1GrJ" AND 
pht.albumName="FirstAlbum" AND
pht.userName="abc" 

WITH r,s,t,pht,cmt
delete r,s,t,pht,cmt;