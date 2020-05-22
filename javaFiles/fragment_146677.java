func NewPath() (p *Path) { // no changes
    p = new(Path)
    p.path = []Cell{}
    p.count = 0
    p.name = "P" + strconv.Itoa(1+p.count)
    return
}

func NewPathFromOriginal(op Path) (p *Path) { // renamed
    p = new(Path)
    p.path = []Cell{}
    p.count = 0
    p.name = op.name
    p.path = append(p.path, op.path...) // note the '...'
    return
}