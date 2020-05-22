bool Bounds::IntersectsBounds(const Bounds &other) const
{
    return !(min.x > other.max.x || max.x < other.min.x
             || min.y > other.max.y || max.y < other.min.y);
}

bool Bounds::Intersection(const Bounds &other, Bounds &outBounds) const
{
    if (!this->IntersectsBounds(other)) {
        return false;
    }

    outBounds.min.x = std::max(min.x, other.min.x);
    outBounds.min.y = std::max(min.y, other.min.y);
    outBounds.max.x = std::min(max.x, other.max.x);
    outBounds.max.y = std::min(max.y, other.max.y);


    return true;
}